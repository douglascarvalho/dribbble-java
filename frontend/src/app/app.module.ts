import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ToastyModule } from 'ng2-toasty';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { routes } from './app.routes';
import { FavoriteComponent } from './favorite/favorite.component';
import { NavigationComponent } from './navigation/navigation.component';
import { CardDeckComponent } from './card-deck/card-deck.component';


@NgModule({
  declarations: [
    AppComponent,
    FavoriteComponent,
    NavigationComponent,
    CardDeckComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    NgbModule.forRoot(),
    ToastyModule.forRoot(),
    RouterModule.forRoot(routes, {
      useHash: true
    })
  ],
  providers: [AppComponent, FavoriteComponent, NavigationComponent],
  bootstrap: [AppComponent, FavoriteComponent, NavigationComponent]
})
export class AppModule { }
