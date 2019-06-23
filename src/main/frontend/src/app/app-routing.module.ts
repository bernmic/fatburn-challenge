import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {TargetComponent} from "./target/target.component";
import {HomeComponent} from "./home/home.component";
import {FoodComponent} from "./food/food.component";
import {FoodDetailComponent} from "./food/food-detail.component";

const routes: Routes = [
  {path: "targets/:id", component: TargetComponent},
  {path: "home", component: HomeComponent},
  {path: "food", component: FoodComponent},
  {path: "food/:id", component: FoodDetailComponent},
  {path: "", redirectTo: "/home", pathMatch: "full"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
