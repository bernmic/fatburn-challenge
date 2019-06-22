import { Component } from '@angular/core';
import {NbSearchService} from "@nebular/theme";
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  value = '';

  constructor(private searchService: NbSearchService, private router: Router) {

    this.searchService.onSearchSubmit()
      .subscribe((data: any) => {
        this.value = data.term;
        this.router.navigate(["/food"], {queryParams: {q: this.value}});
      })

  }
}
