import { Component, OnInit } from '@angular/core';
import { Http, Response, RequestOptions, Headers } from '@angular/http';

import 'rxjs/add/operator/map';
import { environment } from '../../environments/environment';

@Component({
  selector: 'app-favorite',
  templateUrl: './favorite.component.html',
  styleUrls: ['./favorite.component.css']
})
export class FavoriteComponent implements OnInit {

  constructor(private http: Http) { 
    this.getFavoritesScreenshots();
  }

  favoritePageName: string = "favorite"
  data: any = {};

  getData() {
    return this.http.get(`${environment.apiUrl}/favorites`)
      .map((res: Response) => res.json())
  }

  getFavoritesScreenshots(){
    this.getData().subscribe(data => {
      console.log(data);
      this.data = data;
    })
  }

  ngOnInit() {}

}
