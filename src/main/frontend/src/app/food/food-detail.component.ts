import {Component, OnInit} from "@angular/core";
import {FoodService} from "./food.service";
import {ActivatedRoute} from "@angular/router";
import {Food} from "./food.model";

@Component({
  selector: 'app-food-detail',
  templateUrl: './food-detail.component.html',
  styleUrls: ['./food-detail.component.scss']
})
export class FoodDetailComponent implements OnInit {
  food: Food;
  constructor(private route: ActivatedRoute, private foodService: FoodService) {}

  ngOnInit(): void {
    this.route.params.subscribe(p => {
      this.foodService.getFood(p["id"]).subscribe(f => this.food = f)
    })
  }
}
