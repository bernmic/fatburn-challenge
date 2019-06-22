import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {
  NbThemeModule,
  NbLayoutModule,
  NbSidebarModule,
  NbButtonModule,
  NbSidebarService,
  NbListModule,
  NbUserModule,
  NbCardModule,
  NbIconModule,
  NbDialogModule,
  NbInputModule,
  NbDatepickerModule,
  NbSearchModule, NbTreeGridModule
} from '@nebular/theme';
import { NbEvaIconsModule } from '@nebular/eva-icons';
import { PlanComponent } from './plan/plan.component';
import {HttpClientModule} from "@angular/common/http";
import {PlanService} from "./plan/plan.service";
import { TargetComponent } from './target/target.component';
import { HomeComponent } from './home/home.component';
import {TargetService} from "./target/target.service";
import {PlanDialogComponent} from "./plan/plan.dialog";
import {FormsModule} from "@angular/forms";
import {NbMomentDateModule} from "@nebular/moment";
import { FoodComponent } from './food/food.component';
import {FoodService} from "./food/food.service";

@NgModule({
  declarations: [
    AppComponent,
    PlanComponent,
    TargetComponent,
    HomeComponent,
    PlanDialogComponent,
    FoodComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
    NbThemeModule.forRoot({ name: 'dark' }),
    NbLayoutModule,
    NbEvaIconsModule,
    NbSidebarModule,
    NbButtonModule,
    NbListModule,
    NbUserModule,
    NbCardModule,
    NbEvaIconsModule,
    NbIconModule,
    NbDialogModule.forRoot({}),
    NbInputModule,
    NbDatepickerModule.forRoot(),
    NbMomentDateModule,
    NbSearchModule,
    NbTreeGridModule
  ],
  providers: [
    PlanService,
    TargetService,
    FoodService,
    NbSidebarService
  ],
  bootstrap: [AppComponent],
  entryComponents: [
    PlanDialogComponent
  ]
})
export class AppModule { }
