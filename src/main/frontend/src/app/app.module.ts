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
  NbListModule, NbUserModule, NbCardModule, NbIconModule, NbDialogModule, NbInputModule, NbDatepickerModule
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

@NgModule({
  declarations: [
    AppComponent,
    PlanComponent,
    TargetComponent,
    HomeComponent,
    PlanDialogComponent
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
    NbMomentDateModule
  ],
  providers: [
    PlanService,
    TargetService,
    NbSidebarService
  ],
  bootstrap: [AppComponent],
  entryComponents: [
    PlanDialogComponent
  ]
})
export class AppModule { }
