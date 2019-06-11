import { Component, OnInit } from '@angular/core';
import {TargetService} from "./target.service";
import {ActivatedRoute} from "@angular/router";
import {Target} from "./target.model";

@Component({
  selector: 'app-target',
  templateUrl: './target.component.html',
  styleUrls: ['./target.component.scss']
})
export class TargetComponent implements OnInit {
  targets: Target[];

  constructor(
    private route: ActivatedRoute,
    private targetService: TargetService
  ) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      var idString = params.get('id');
      console.log(idString);
      this.targetService.getTargets(+idString).subscribe(t => this.targets = t);
    });
  }

  highlighted(target: Target): boolean {
    var today = new Date();
    var theday = new Date(target.date)
    today.setHours(0,0,0,0);
    theday.setHours(0,0,0,0);
    if (theday.getTime() === today.getTime()) {
      return true;
    }
    return false;
  }

  scroll(el: HTMLElement) {
    el.scrollIntoView();
  }
}
