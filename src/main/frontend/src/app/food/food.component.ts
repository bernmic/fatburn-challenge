import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {FoodService} from "./food.service";
import {Food} from "./food.model";

interface TreeNode<T> {
  data: T;
  children?: TreeNode<T>[];
  expanded?: boolean;
}

@Component({
  selector: 'app-food',
  templateUrl: './food.component.html',
  styleUrls: ['./food.component.scss']
})
export class FoodComponent implements OnInit {
  query = "";
  foods: Food[];
  allColumns = ["name", "brand", "calories", "carbohydrates", "protein", "fat", "barcode"];

  data: TreeNode<Food>[] = [];

  constructor(private route: ActivatedRoute, private foodService: FoodService) { }

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      this.query = params["q"];
      this.foodService.findFoods(this.query).subscribe(f => {
        this.foods = f;
        this.data = [];
        for (let food of this.foods) {
          this.data.push({
            data: food
          });
        }
      });
    });
  }

}
