import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Plan} from "./plan.model";
import {environment} from "../../environments/environment";
import {DatePipe} from "@angular/common";

@Injectable()
export class PlanService {
  constructor(private http: HttpClient, private datePipe: DatePipe) {}

  getPlans(): Observable<Plan[]> {
    return this.http.get<Plan[]>(environment.restserver + "/plan");
  }

  createPlan(plan: Plan): Observable<Plan> {
    var startDate = this.datePipe.transform(plan.startDate, "yyyy-MM-dd");
    return this.http.post<Plan>(environment.restserver + "/plan", {user: plan.user, weight: plan.weight, startDate: startDate});
  }
}
