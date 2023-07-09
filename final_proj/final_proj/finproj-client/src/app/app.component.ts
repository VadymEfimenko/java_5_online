import {Component} from '@angular/core';
import {RouterOutlet} from "@angular/router";
import {FooterComponent} from "./layout/footer/footer.component";

@Component({
  selector: 'app-root',
  standalone: true,
  templateUrl: './app.component.html',
  imports: [
    RouterOutlet,
    FooterComponent
  ],
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'finproj-client';
}
