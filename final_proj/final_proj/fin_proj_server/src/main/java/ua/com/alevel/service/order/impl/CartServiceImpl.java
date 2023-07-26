package ua.com.alevel.service.order.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.config.security.AuthenticationService;
import ua.com.alevel.exception.EntityNotFoundException;
import ua.com.alevel.persistence.sql.entity.order.Cart;
import ua.com.alevel.persistence.sql.entity.order.CartEntry;
import ua.com.alevel.persistence.sql.entity.user.Personal;
import ua.com.alevel.persistence.sql.repository.order.CartEntryRepository;
import ua.com.alevel.persistence.sql.repository.order.CartRepository;
import ua.com.alevel.service.order.CartService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static ua.com.alevel.util.ExceptionUtil.ENTITY_NOT_FOUND;

@Service
@Transactional
@AllArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CartEntryRepository cartEntryRepository;
    private final AuthenticationService authenticationService;

    @Override
    public void add(CartEntry cartEntry) {
        Personal personal = authenticationService.findPersonal();
        Optional<Cart> optionalCart = cartRepository.findByPersonalAndActiveTrue(personal);
        Cart cart = null;
        if (optionalCart.isEmpty()) {
            cart = new Cart();
            cart.setPersonal(personal);
            cart = cartRepository.save(cart);
        } else {
            cart = optionalCart.get();
        }
        cartEntry.setCart(cart);
        cartEntryRepository.save(cartEntry);
    }

    @Override
    public void update(CartEntry cartEntry) {

    }

    @Override
    public void remove(CartEntry cartEntry) {

    }

    @Override
    public void clear() {
        Personal personal = authenticationService.findPersonal();
        Optional<Cart> optionalCart = cartRepository.findByPersonalAndActiveTrue(personal);
        cartEntryRepository.deleteAllByCart(optionalCart.get());
    }

    @Override
    public Cart getActive() {
        Personal personal = authenticationService.findPersonal();
        return cartRepository
                .findByPersonalAndActiveTrue(personal)
                .orElseThrow(() -> new EntityNotFoundException(ENTITY_NOT_FOUND));
    }

//    @Override
//    public List<CartEntry> findByCart(Cart cart) {
//        System.out.println(cartEntryRepository.findAllByCart(cart));
//        return cartEntryRepository.findAllByCart(cart);
//    }


    @Override
    public List<CartEntry> findByCart(Cart cart) {
        List<CartEntry> entries = cartEntryRepository.findAllByCart(cart);
        List<CartEntry> cartEntryListDistinct = new ArrayList<>();
        List<Long> varIds = new ArrayList<>(entries.stream().map(cartEntry -> cartEntry.getProductVariant().getId()).distinct().toList());
        for (int i = 0; i < varIds.size(); i++) {
            int quantity = 0;
            for (int j = 0; j < entries.size(); j++) {
                if (Objects.equals(entries.get(j).getProductVariant().getId(), varIds.get(i))){
                    quantity++;
                }
            }
            Long id = varIds.get(i);
            for (CartEntry entry : entries) {
                if (entry.getProductVariant().getId() == id){
                    entry.setQuantity(quantity);
                    cartEntryListDistinct.add(entry);
                    break;
                }
            }
        }
        return cartEntryListDistinct;
    }
}
