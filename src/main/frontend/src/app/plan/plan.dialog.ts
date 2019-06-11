import {Component, OnInit} from "@angular/core";
import {NbDialogRef} from "@nebular/theme";
import * as moment from 'moment'
import {PlanService} from "./plan.service";
import {Plan} from "./plan.model";

@Component({
  selector: 'app-plan-dialog',
  templateUrl: './plan.dialog.html',
  styleUrls: ['./plan.dialog.scss']
})
export class PlanDialogComponent implements OnInit {

  constructor(
    private planService: PlanService,
    protected ref: NbDialogRef<PlanDialogComponent>) {}

  ngOnInit(): void {
  }

  okPressed(name: string, weight: string, startdate: string) {
    var w = +weight;
    var sd = moment(startdate, "DD.MM.YYYY").toDate();
    this.planService.createPlan(new Plan(null, name, sd, w)).subscribe(p => {
      this.ref.close(p);
    });
  }

  cancelPressed() {
    this.ref.close();
  }
}
