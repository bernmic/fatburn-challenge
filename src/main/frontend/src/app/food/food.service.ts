import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";
import {Food} from "./food.model";

@Injectable()
export class FoodService {

  constructor(private http: HttpClient) {}

  findFoods(filter: string): Observable<Food[]> {
    return this.http.get<Food[]>(environment.restserver + "/food?filter=" + encodeURI(filter));
  }

  getFood(id: string): Observable<Food> {
    return this.http.get<Food>(environment.restserver + "/food/" + encodeURI(id));
  }
}
