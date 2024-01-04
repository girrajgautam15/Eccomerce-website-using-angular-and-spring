import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ItemsComponent } from './items/items.component';

export const routes: Routes = [
    {path:"",component:LoginComponent},
    {path:'items',component:ItemsComponent}
];
