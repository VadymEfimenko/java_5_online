insert into products
values (1,
        'Signature Red Tomato Sauce on our Signature Stuffed Crust, topped with 100% whole milk mozzarella, Canadian-style bacon, applewood smoked bacon, juicy pineapple chunks, and extra mozzarella.',
        'Hawaiian Luau Stuffed Crust Pizza');
insert into products
values (2,
        'Tuscany thin crust, all-natural grilled chicken, applewood smoked bacon, juicy pineapple chunks, green bell pepper, and a BBQ sauce drizzle',
        'Hawaiian BBQ');
insert into products
values (3,
        'Signature Tomato Red Sauce base on our Tuscany Crust, topped with Mozzarella, Cup & Crisp Pepperoni, Jalapenos, Italian Sausage, and Crushed Red Pepper.',
        'Fireworks Pizza');
insert into products
values (4,
        'Signature Red Tomato Sauce on our Signature Stuffed Crust, topped with 100% whole milk Mozzarella, Cheddar, Parmesan, Asiago, and Romano cheeses.',
        'Five Cheese Stuffed Crust');
insert into products
values (5,
        'Signature white garlic sauce on our Tuscany thin crust, topped with 100% whole milk mozzarella cheese, baby spinach, cup & crisp pepperoni, sliced red onions, and diced tomatoes.',
        'Ultimate Spinach Pepperoni');
insert into products
values (6,
        'Signature white garlic sauce on our original crust, topped with 100% whole milk mozzarella cheese, curry seasoning, all-natural grilled chicken, red onions, green bell peppers, diced tomatoes, and fresh cilantro.',
        'Curry Chicken Delight');
insert into products
values (7,
        'Original Signature crust, creamy pesto sauce, 100% whole milk mozzarella, Italian salami, marinated artichoke hearts, green olives, and diced tomatoes.',
        'Mediterranean Pizza');
insert into products
values (8,
        'Original Signature crust, 100% whole milk mozzarella, Canadian-style bacon, applewood smoked bacon, sliced red onions, Dole® pineapple chunks, Kogi™ Serrano Chili sauce drizzle, and topped with fresh chopped cilantro.',
        'Serrano Chili Pizza');

insert into product_images
values (1,
        'https://tcdn.tchpt.com/admin/aux?b=c1~4066c4e45b62c35f92d362574ab3a0c91&a=c1~1203&f=HawaiianTPimages_1024x768__2023-04-26_23-17-32.jpg',
        true,'Hawaiian Luau Stuffed Crust Pizza');
insert into product_images
values (2,
        'https://tcdn.tchpt.com/admin/aux?b=c1~4066c4e45b62c35f92d362574ab3a0c91&a=c1~1204&f=HawaiianBBQTPimages_1024x768__2023-04-26_23-09-17.jpg',
        true,'Hawaiian BBQ');
insert into product_images
values (3,
        'https://tcdn.tchpt.com/admin/aux?b=c1~4066c4e45b62c35f92d362574ab3a0c91&a=c1~534&f=Fireworks_1024x768__2019-07-02_18-28-18.jpg',
        true,'Fireworks Pizza');
insert into product_images
values (4,
        'https://tcdn.tchpt.com/admin/aux?b=c1~4066c4e45b62c35f92d362574ab3a0c91&a=c1~1141&f=SPOM-5Cheese-1024x768__2023-02-27_18-09-55.jpg',
        true,'Five Cheese Stuffed Crust');
insert into product_images
values (5,
        'https://tcdn.tchpt.com/admin/aux?b=c1~4066c4e45b62c35f92d362574ab3a0c91&a=c1~932&f=Ultimate+Spinach+Pepperoni_1024x768__2022-02-24_23-26-18.jpg',
        true,'Ultimate Spinach Pepperoni');
insert into product_images
values (6,
        'https://tcdn.tchpt.com/admin/aux?b=c1~4066c4e45b62c35f92d362574ab3a0c91&a=c1~901&f=TP_CurryChickenDelight_1024x768__2021-08-04_17-32-35.jpg',
        true,'Curry Chicken Delight');
insert into product_images
values (7,
        'https://tcdn.tchpt.com/admin/aux?b=c1~4066c4e45b62c35f92d362574ab3a0c91&a=c1~880&f=MediterraneanPizza_1024x768__2021-05-28_6-31-47.jpg',
        true,'Mediterranean Pizza');
insert into product_images
values (8,
        'https://tcdn.tchpt.com/admin/aux?b=c1~4066c4e45b62c35f92d362574ab3a0c91&a=c1~576&f=KogiSerranoChili_1024x768__2019-07-30_17-33-45.jpg',
        true,'Serrano Chili Pizza');

insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','SPICY',199,40,'STANDARD',1);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','SPICY',199,40,'DOUBLE',1);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','SPICY',199,50,'STANDARD',1);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','SPICY',199,50,'DOUBLE',1);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','SPICY',199,40,'STANDARD',1);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','SPICY',199,40,'DOUBLE',1);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','SPICY',199,50,'STANDARD',1);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','SPICY',199,50,'DOUBLE',1);

insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CREAMY',199,40,'STANDARD',1);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CREAMY',199,40,'DOUBLE',1);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CREAMY',199,50,'STANDARD',1);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CREAMY',199,50,'DOUBLE',1);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CREAMY',199,40,'STANDARD',1);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CREAMY',199,40,'DOUBLE',1);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CREAMY',199,50,'STANDARD',1);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CREAMY',199,50,'DOUBLE',1);

insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CAESAR',199,40,'STANDARD',1);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CAESAR',199,40,'DOUBLE',1);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CAESAR',199,50,'STANDARD',1);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CAESAR',199,50,'DOUBLE',1);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CAESAR',199,40,'STANDARD',1);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CAESAR',199,40,'DOUBLE',1);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CAESAR',199,50,'STANDARD',1);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CAESAR',199,50,'DOUBLE',1);



insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',239,40,'STANDARD',1);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',239,40,'DOUBLE',1);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',239,50,'STANDARD',1);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',239,50,'DOUBLE',1);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',239,40,'STANDARD',1);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',239,40,'DOUBLE',1);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',239,50,'STANDARD',1);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',239,50,'DOUBLE',1);

insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',239,40,'STANDARD',1);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',239,40,'DOUBLE',1);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',239,50,'STANDARD',1);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',239,50,'DOUBLE',1);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',239,40,'STANDARD',1);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',239,40,'DOUBLE',1);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',239,50,'STANDARD',1);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',239,50,'DOUBLE',1);

insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',239,40,'STANDARD',1);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',239,40,'DOUBLE',1);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',239,50,'STANDARD',1);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',239,50,'DOUBLE',1);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',239,40,'STANDARD',1);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',239,40,'DOUBLE',1);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',239,50,'STANDARD',1);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',239,50,'DOUBLE',1);



insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',249,40,'STANDARD',1);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',249,40,'DOUBLE',1);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',249,50,'STANDARD',1);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',249,50,'DOUBLE',1);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',249,40,'STANDARD',1);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',249,40,'DOUBLE',1);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',249,50,'STANDARD',1);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',249,50,'DOUBLE',1);

insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',249,40,'STANDARD',1);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',249,40,'DOUBLE',1);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',249,50,'STANDARD',1);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',249,50,'DOUBLE',1);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',249,40,'STANDARD',1);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',249,40,'DOUBLE',1);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',249,50,'STANDARD',1);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',249,50,'DOUBLE',1);

insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',249,40,'STANDARD',1);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',249,40,'DOUBLE',1);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',249,50,'STANDARD',1);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',249,50,'DOUBLE',1);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',249,40,'STANDARD',1);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',249,40,'DOUBLE',1);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',249,50,'STANDARD',1);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',249,50,'DOUBLE',1);

#2
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','SPICY',249,40,'STANDARD',2);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','SPICY',249,40,'DOUBLE',2);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','SPICY',249,50,'STANDARD',2);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','SPICY',249,50,'DOUBLE',2);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','SPICY',249,40,'STANDARD',2);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','SPICY',249,40,'DOUBLE',2);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','SPICY',249,50,'STANDARD',2);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','SPICY',249,50,'DOUBLE',2);

insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CREAMY',249,40,'STANDARD',2);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CREAMY',249,40,'DOUBLE',2);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CREAMY',249,50,'STANDARD',2);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CREAMY',249,50,'DOUBLE',2);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CREAMY',249,40,'STANDARD',2);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CREAMY',249,40,'DOUBLE',2);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CREAMY',249,50,'STANDARD',2);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CREAMY',249,50,'DOUBLE',2);

insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CAESAR',249,40,'STANDARD',2);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CAESAR',249,40,'DOUBLE',2);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CAESAR',249,50,'STANDARD',2);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CAESAR',249,50,'DOUBLE',2);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CAESAR',249,40,'STANDARD',2);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CAESAR',249,40,'DOUBLE',2);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CAESAR',249,50,'STANDARD',2);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CAESAR',249,50,'DOUBLE',2);



insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,40,'STANDARD',2);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,40,'DOUBLE',2);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,50,'STANDARD',2);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,50,'DOUBLE',2);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,40,'STANDARD',2);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,40,'DOUBLE',2);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,50,'STANDARD',2);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,50,'DOUBLE',2);

insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,40,'STANDARD',2);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,40,'DOUBLE',2);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,50,'STANDARD',2);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,50,'DOUBLE',2);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,40,'STANDARD',2);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,40,'DOUBLE',2);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,50,'STANDARD',2);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,50,'DOUBLE',2);

insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,40,'STANDARD',2);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,40,'DOUBLE',2);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,50,'STANDARD',2);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,50,'DOUBLE',2);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,40,'STANDARD',2);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,40,'DOUBLE',2);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,50,'STANDARD',2);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,50,'DOUBLE',2);



insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,40,'STANDARD',2);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,40,'DOUBLE',2);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,50,'STANDARD',2);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,50,'DOUBLE',2);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,40,'STANDARD',2);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,40,'DOUBLE',2);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,50,'STANDARD',2);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,50,'DOUBLE',2);

insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,40,'STANDARD',2);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,40,'DOUBLE',2);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,50,'STANDARD',2);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,50,'DOUBLE',2);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,40,'STANDARD',2);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,40,'DOUBLE',2);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,50,'STANDARD',2);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,50,'DOUBLE',2);

insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,40,'STANDARD',2);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,40,'DOUBLE',2);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,50,'STANDARD',2);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,50,'DOUBLE',2);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,40,'STANDARD',2);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,40,'DOUBLE',2);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,50,'STANDARD',2);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,50,'DOUBLE',2);


#3

insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','SPICY',249,40,'STANDARD',3);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','SPICY',249,40,'DOUBLE',3);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','SPICY',249,50,'STANDARD',3);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','SPICY',249,50,'DOUBLE',3);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','SPICY',249,40,'STANDARD',3);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','SPICY',249,40,'DOUBLE',3);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','SPICY',249,50,'STANDARD',3);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','SPICY',249,50,'DOUBLE',3);

insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CREAMY',249,40,'STANDARD',3);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CREAMY',249,40,'DOUBLE',3);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CREAMY',249,50,'STANDARD',3);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CREAMY',249,50,'DOUBLE',3);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CREAMY',249,40,'STANDARD',3);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CREAMY',249,40,'DOUBLE',3);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CREAMY',249,50,'STANDARD',3);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CREAMY',249,50,'DOUBLE',3);

insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CAESAR',249,40,'STANDARD',3);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CAESAR',249,40,'DOUBLE',3);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CAESAR',249,50,'STANDARD',3);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CAESAR',249,50,'DOUBLE',3);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CAESAR',249,40,'STANDARD',3);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CAESAR',249,40,'DOUBLE',3);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CAESAR',249,50,'STANDARD',3);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CAESAR',249,50,'DOUBLE',3);



insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,40,'STANDARD',3);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,40,'DOUBLE',3);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,50,'STANDARD',3);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,50,'DOUBLE',3);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,40,'STANDARD',3);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,40,'DOUBLE',3);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,50,'STANDARD',3);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,50,'DOUBLE',3);

insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,40,'STANDARD',3);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,40,'DOUBLE',3);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,50,'STANDARD',3);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,50,'DOUBLE',3);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,40,'STANDARD',3);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,40,'DOUBLE',3);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,50,'STANDARD',3);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,50,'DOUBLE',3);

insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,40,'STANDARD',3);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,40,'DOUBLE',3);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,50,'STANDARD',3);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,50,'DOUBLE',3);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,40,'STANDARD',3);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,40,'DOUBLE',3);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,50,'STANDARD',3);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,50,'DOUBLE',3);



insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,40,'STANDARD',3);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,40,'DOUBLE',3);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,50,'STANDARD',3);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,50,'DOUBLE',3);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,40,'STANDARD',3);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,40,'DOUBLE',3);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,50,'STANDARD',3);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,50,'DOUBLE',3);

insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,40,'STANDARD',3);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,40,'DOUBLE',3);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,50,'STANDARD',3);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,50,'DOUBLE',3);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,40,'STANDARD',3);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,40,'DOUBLE',3);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,50,'STANDARD',3);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,50,'DOUBLE',3);

insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,40,'STANDARD',3);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,40,'DOUBLE',3);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,50,'STANDARD',3);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,50,'DOUBLE',3);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,40,'STANDARD',3);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,40,'DOUBLE',3);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,50,'STANDARD',3);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,50,'DOUBLE',3);

#4

insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','SPICY',249,40,'STANDARD',4);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','SPICY',249,40,'DOUBLE',4);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','SPICY',249,50,'STANDARD',4);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','SPICY',249,50,'DOUBLE',4);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','SPICY',249,40,'STANDARD',4);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','SPICY',249,40,'DOUBLE',4);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','SPICY',249,50,'STANDARD',4);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','SPICY',249,50,'DOUBLE',4);

insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CREAMY',249,40,'STANDARD',4);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CREAMY',249,40,'DOUBLE',4);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CREAMY',249,50,'STANDARD',4);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CREAMY',249,50,'DOUBLE',4);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CREAMY',249,40,'STANDARD',4);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CREAMY',249,40,'DOUBLE',4);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CREAMY',249,50,'STANDARD',4);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CREAMY',249,50,'DOUBLE',4);

insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CAESAR',249,40,'STANDARD',4);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CAESAR',249,40,'DOUBLE',4);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CAESAR',249,50,'STANDARD',4);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CAESAR',249,50,'DOUBLE',4);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CAESAR',249,40,'STANDARD',4);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CAESAR',249,40,'DOUBLE',4);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CAESAR',249,50,'STANDARD',4);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CAESAR',249,50,'DOUBLE',4);



insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,40,'STANDARD',4);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,40,'DOUBLE',4);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,50,'STANDARD',4);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,50,'DOUBLE',4);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,40,'STANDARD',4);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,40,'DOUBLE',4);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,50,'STANDARD',4);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,50,'DOUBLE',4);

insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,40,'STANDARD',4);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,40,'DOUBLE',4);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,50,'STANDARD',4);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,50,'DOUBLE',4);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,40,'STANDARD',4);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,40,'DOUBLE',4);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,50,'STANDARD',4);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,50,'DOUBLE',4);

insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,40,'STANDARD',4);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,40,'DOUBLE',4);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,50,'STANDARD',4);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,50,'DOUBLE',4);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,40,'STANDARD',4);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,40,'DOUBLE',4);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,50,'STANDARD',4);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,50,'DOUBLE',4);



insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,40,'STANDARD',4);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,40,'DOUBLE',4);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,50,'STANDARD',4);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,50,'DOUBLE',4);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,40,'STANDARD',4);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,40,'DOUBLE',4);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,50,'STANDARD',4);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,50,'DOUBLE',4);

insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,40,'STANDARD',4);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,40,'DOUBLE',4);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,50,'STANDARD',4);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,50,'DOUBLE',4);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,40,'STANDARD',4);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,40,'DOUBLE',4);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,50,'STANDARD',4);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,50,'DOUBLE',4);

insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,40,'STANDARD',4);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,40,'DOUBLE',4);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,50,'STANDARD',4);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,50,'DOUBLE',4);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,40,'STANDARD',4);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,40,'DOUBLE',4);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,50,'STANDARD',4);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,50,'DOUBLE',4);

#5


insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','SPICY',249,40,'STANDARD',5);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','SPICY',249,40,'DOUBLE',5);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','SPICY',249,50,'STANDARD',5);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','SPICY',249,50,'DOUBLE',5);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','SPICY',249,40,'STANDARD',5);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','SPICY',249,40,'DOUBLE',5);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','SPICY',249,50,'STANDARD',5);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','SPICY',249,50,'DOUBLE',5);

insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CREAMY',249,40,'STANDARD',5);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CREAMY',249,40,'DOUBLE',5);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CREAMY',249,50,'STANDARD',5);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CREAMY',249,50,'DOUBLE',5);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CREAMY',249,40,'STANDARD',5);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CREAMY',249,40,'DOUBLE',5);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CREAMY',249,50,'STANDARD',5);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CREAMY',249,50,'DOUBLE',5);

insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CAESAR',249,40,'STANDARD',5);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CAESAR',249,40,'DOUBLE',5);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CAESAR',249,50,'STANDARD',5);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CAESAR',249,50,'DOUBLE',5);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CAESAR',249,40,'STANDARD',5);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CAESAR',249,40,'DOUBLE',5);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CAESAR',249,50,'STANDARD',5);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CAESAR',249,50,'DOUBLE',5);



insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,40,'STANDARD',5);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,40,'DOUBLE',5);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,50,'STANDARD',5);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,50,'DOUBLE',5);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,40,'STANDARD',5);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,40,'DOUBLE',5);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,50,'STANDARD',5);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,50,'DOUBLE',5);

insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,40,'STANDARD',5);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,40,'DOUBLE',5);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,50,'STANDARD',5);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,50,'DOUBLE',5);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,40,'STANDARD',5);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,40,'DOUBLE',5);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,50,'STANDARD',5);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,50,'DOUBLE',5);

insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,40,'STANDARD',5);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,40,'DOUBLE',5);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,50,'STANDARD',5);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,50,'DOUBLE',5);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,40,'STANDARD',5);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,40,'DOUBLE',5);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,50,'STANDARD',5);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,50,'DOUBLE',5);



insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,40,'STANDARD',5);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,40,'DOUBLE',5);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,50,'STANDARD',5);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,50,'DOUBLE',5);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,40,'STANDARD',5);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,40,'DOUBLE',5);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,50,'STANDARD',5);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,50,'DOUBLE',5);

insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,40,'STANDARD',5);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,40,'DOUBLE',5);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,50,'STANDARD',5);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,50,'DOUBLE',5);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,40,'STANDARD',5);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,40,'DOUBLE',5);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,50,'STANDARD',5);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,50,'DOUBLE',5);

insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,40,'STANDARD',5);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,40,'DOUBLE',5);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,50,'STANDARD',5);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,50,'DOUBLE',5);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,40,'STANDARD',5);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,40,'DOUBLE',5);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,50,'STANDARD',5);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,50,'DOUBLE',5);

#6


insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','SPICY',249,40,'STANDARD',6);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','SPICY',249,40,'DOUBLE',6);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','SPICY',249,50,'STANDARD',6);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','SPICY',249,50,'DOUBLE',6);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','SPICY',249,40,'STANDARD',6);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','SPICY',249,40,'DOUBLE',6);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','SPICY',249,50,'STANDARD',6);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','SPICY',249,50,'DOUBLE',6);

insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CREAMY',249,40,'STANDARD',6);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CREAMY',249,40,'DOUBLE',6);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CREAMY',249,50,'STANDARD',6);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CREAMY',249,50,'DOUBLE',6);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CREAMY',249,40,'STANDARD',6);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CREAMY',249,40,'DOUBLE',6);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CREAMY',249,50,'STANDARD',6);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CREAMY',249,50,'DOUBLE',6);

insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CAESAR',249,40,'STANDARD',6);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CAESAR',249,40,'DOUBLE',6);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CAESAR',249,50,'STANDARD',6);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CAESAR',249,50,'DOUBLE',6);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CAESAR',249,40,'STANDARD',6);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CAESAR',249,40,'DOUBLE',6);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CAESAR',249,50,'STANDARD',6);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CAESAR',249,50,'DOUBLE',6);



insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,40,'STANDARD',6);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,40,'DOUBLE',6);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,50,'STANDARD',6);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,50,'DOUBLE',6);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,40,'STANDARD',6);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,40,'DOUBLE',6);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,50,'STANDARD',6);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,50,'DOUBLE',6);

insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,40,'STANDARD',6);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,40,'DOUBLE',6);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,50,'STANDARD',6);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,50,'DOUBLE',6);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,40,'STANDARD',6);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,40,'DOUBLE',6);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,50,'STANDARD',6);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,50,'DOUBLE',6);

insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,40,'STANDARD',6);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,40,'DOUBLE',6);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,50,'STANDARD',6);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,50,'DOUBLE',6);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,40,'STANDARD',6);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,40,'DOUBLE',6);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,50,'STANDARD',6);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,50,'DOUBLE',6);



insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,40,'STANDARD',6);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,40,'DOUBLE',6);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,50,'STANDARD',6);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,50,'DOUBLE',6);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,40,'STANDARD',6);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,40,'DOUBLE',6);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,50,'STANDARD',6);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,50,'DOUBLE',6);

insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,40,'STANDARD',6);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,40,'DOUBLE',6);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,50,'STANDARD',6);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,50,'DOUBLE',6);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,40,'STANDARD',6);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,40,'DOUBLE',6);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,50,'STANDARD',6);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,50,'DOUBLE',6);

insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,40,'STANDARD',6);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,40,'DOUBLE',6);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,50,'STANDARD',6);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,50,'DOUBLE',6);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,40,'STANDARD',6);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,40,'DOUBLE',6);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,50,'STANDARD',6);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,50,'DOUBLE',6);


#7
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','SPICY',249,40,'STANDARD',7);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','SPICY',249,40,'DOUBLE',7);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','SPICY',249,50,'STANDARD',7);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','SPICY',249,50,'DOUBLE',7);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','SPICY',249,40,'STANDARD',7);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','SPICY',249,40,'DOUBLE',7);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','SPICY',249,50,'STANDARD',7);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','SPICY',249,50,'DOUBLE',7);

insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CREAMY',249,40,'STANDARD',7);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CREAMY',249,40,'DOUBLE',7);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CREAMY',249,50,'STANDARD',7);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CREAMY',249,50,'DOUBLE',7);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CREAMY',249,40,'STANDARD',7);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CREAMY',249,40,'DOUBLE',7);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CREAMY',249,50,'STANDARD',7);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CREAMY',249,50,'DOUBLE',7);

insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CAESAR',249,40,'STANDARD',7);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CAESAR',249,40,'DOUBLE',7);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CAESAR',249,50,'STANDARD',7);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CAESAR',249,50,'DOUBLE',7);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CAESAR',249,40,'STANDARD',7);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CAESAR',249,40,'DOUBLE',7);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CAESAR',249,50,'STANDARD',7);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CAESAR',249,50,'DOUBLE',7);



insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,40,'STANDARD',7);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,40,'DOUBLE',7);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,50,'STANDARD',7);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,50,'DOUBLE',7);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,40,'STANDARD',7);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,40,'DOUBLE',7);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,50,'STANDARD',7);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,50,'DOUBLE',7);

insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,40,'STANDARD',7);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,40,'DOUBLE',7);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,50,'STANDARD',7);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,50,'DOUBLE',7);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,40,'STANDARD',7);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,40,'DOUBLE',7);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,50,'STANDARD',7);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,50,'DOUBLE',7);

insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,40,'STANDARD',7);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,40,'DOUBLE',7);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,50,'STANDARD',7);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,50,'DOUBLE',7);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,40,'STANDARD',7);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,40,'DOUBLE',7);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,50,'STANDARD',7);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,50,'DOUBLE',7);



insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,40,'STANDARD',7);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,40,'DOUBLE',7);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,50,'STANDARD',7);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,50,'DOUBLE',7);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,40,'STANDARD',7);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,40,'DOUBLE',7);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,50,'STANDARD',7);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,50,'DOUBLE',7);

insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,40,'STANDARD',7);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,40,'DOUBLE',7);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,50,'STANDARD',7);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,50,'DOUBLE',7);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,40,'STANDARD',7);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,40,'DOUBLE',7);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,50,'STANDARD',7);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,50,'DOUBLE',7);

insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,40,'STANDARD',7);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,40,'DOUBLE',7);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,50,'STANDARD',7);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,50,'DOUBLE',7);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,40,'STANDARD',7);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,40,'DOUBLE',7);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,50,'STANDARD',7);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,50,'DOUBLE',7);


#8

insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','SPICY',249,40,'STANDARD',8);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','SPICY',249,40,'DOUBLE',8);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','SPICY',249,50,'STANDARD',8);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','SPICY',249,50,'DOUBLE',8);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','SPICY',249,40,'STANDARD',8);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','SPICY',249,40,'DOUBLE',8);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','SPICY',249,50,'STANDARD',8);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','SPICY',249,50,'DOUBLE',8);

insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CREAMY',249,40,'STANDARD',8);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CREAMY',249,40,'DOUBLE',8);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CREAMY',249,50,'STANDARD',8);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CREAMY',249,50,'DOUBLE',8);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CREAMY',249,40,'STANDARD',8);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CREAMY',249,40,'DOUBLE',8);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CREAMY',249,50,'STANDARD',8);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CREAMY',249,50,'DOUBLE',8);

insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CAESAR',249,40,'STANDARD',8);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CAESAR',249,40,'DOUBLE',8);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CAESAR',249,50,'STANDARD',8);
insert into product_variants values (default, 'STANDARD', 'CHEESE_CORNICIONE','CAESAR',249,50,'DOUBLE',8);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CAESAR',249,40,'STANDARD',8);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CAESAR',249,40,'DOUBLE',8);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CAESAR',249,50,'STANDARD',8);
insert into product_variants values (default, 'DOUBLE', 'CHEESE_CORNICIONE','CAESAR',249,50,'DOUBLE',8);



insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,40,'STANDARD',8);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,40,'DOUBLE',8);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,50,'STANDARD',8);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,50,'DOUBLE',8);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,40,'STANDARD',8);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,40,'DOUBLE',8);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,50,'STANDARD',8);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','SPICY',269,50,'DOUBLE',8);

insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,40,'STANDARD',8);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,40,'DOUBLE',8);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,50,'STANDARD',8);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,50,'DOUBLE',8);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,40,'STANDARD',8);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,40,'DOUBLE',8);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,50,'STANDARD',8);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CREAMY',269,50,'DOUBLE',8);

insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,40,'STANDARD',8);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,40,'DOUBLE',8);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,50,'STANDARD',8);
insert into product_variants values (default, 'STANDARD', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,50,'DOUBLE',8);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,40,'STANDARD',8);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,40,'DOUBLE',8);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,50,'STANDARD',8);
insert into product_variants values (default, 'DOUBLE', 'HUNTERS_SAUSAGE_CORNICIONE','CAESAR',269,50,'DOUBLE',8);



insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,40,'STANDARD',8);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,40,'DOUBLE',8);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,50,'STANDARD',8);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,50,'DOUBLE',8);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,40,'STANDARD',8);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,40,'DOUBLE',8);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,50,'STANDARD',8);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','SPICY',279,50,'DOUBLE',8);

insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,40,'STANDARD',8);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,40,'DOUBLE',8);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,50,'STANDARD',8);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,50,'DOUBLE',8);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,40,'STANDARD',8);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,40,'DOUBLE',8);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,50,'STANDARD',8);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CREAMY',279,50,'DOUBLE',8);

insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,40,'STANDARD',8);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,40,'DOUBLE',8);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,50,'STANDARD',8);
insert into product_variants values (default, 'STANDARD', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,50,'DOUBLE',8);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,40,'STANDARD',8);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,40,'DOUBLE',8);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,50,'STANDARD',8);
insert into product_variants values (default, 'DOUBLE', 'VIENNA_SAUSAGES_CORNICIONE','CAESAR',279,50,'DOUBLE',8);



insert into product_image values (1,1);
insert into product_image values (2,2);
insert into product_image values (3,3);
insert into product_image values (4,4);
insert into product_image values (5,5);
insert into product_image values (6,6);
insert into product_image values (7,7);
insert into product_image values (8,8);



