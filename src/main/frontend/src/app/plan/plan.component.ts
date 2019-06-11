import { Component, OnInit } from '@angular/core';
import {PlanService} from "./plan.service";
import {Plan} from "./plan.model";
import {NbDialogService} from "@nebular/theme";
import {PlanDialogComponent} from "./plan.dialog";
import {Router} from "@angular/router";

@Component({
  selector: 'app-plan',
  templateUrl: './plan.component.html',
  styleUrls: ['./plan.component.scss']
})
export class PlanComponent implements OnInit {
  plans: Plan[];

  constructor(
    private planService: PlanService,
    private dialogService: NbDialogService,
    private router: Router) { }

  ngOnInit() {
    this.planService.getPlans().subscribe(p => {
      this.plans = p;
    });
  }

  openPlanDialog() {
    this.dialogService.open(PlanDialogComponent, { closeOnBackdropClick: false }).onClose.subscribe(p => {
      this.plans.push(p);
      this.router.navigate(["/targets/"+ p.id]);
    });
  }
}
