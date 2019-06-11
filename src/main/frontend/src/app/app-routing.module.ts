import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {TargetComponent} from "./target/target.component";
import {HomeComponent} from "./home/home.component";

const routes: Routes = [
  {path: "targets/:id", component: TargetComponent},
  {path: "home", component: HomeComponent},
  {path: "", redirectTo: "/home", pathMatch: "full"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
