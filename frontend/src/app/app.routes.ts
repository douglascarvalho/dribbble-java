import { Routes } from '@angular/router';
import { NavigationComponent } from './navigation/navigation.component';
import { FavoriteComponent } from './favorite/favorite.component';

export const routes: Routes = [
    { path: '', redirectTo: 'navigation', pathMatch: 'full' },    
    { path: 'navigation', component: NavigationComponent },
    { path: 'favorites', component: FavoriteComponent }    
];