import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Target} from "./target.model";
import {environment} from "../../environments/environment";

@Injectable()
export class TargetService {
  constructor(private http: HttpClient) {}

  getTargets(id: number): Observable<Target[]> {
    return this.http.get<Target[]>(environment.restserver + "/plan/" + id  + "/targets");
  }
}
