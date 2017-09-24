import { Component, OnInit } from '@angular/core';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { HttpParams } from '@angular/common/http';

import 'rxjs/add/operator/map';
import { environment } from '../../environments/environment';

const FAVORITE_FILTER_INSERT_DATE: number = 1;
const FAVORITE_FILTER_RECENTLY_ADDED: number = 2;

@Component({
  selector: 'app-favorite',
  templateUrl: './favorite.component.html',
  styleUrls: ['./favorite.component.css']
})
export class FavoriteComponent implements OnInit {

  constructor(private http: Http) { 
    this.getDataByInsertDate();
  }

  favoritePageName: string = "favorite"
  data: any = {};

  getData(favoriteFilter) {
    return this.http.get(`${environment.apiUrl}/favorites?favoriteFilter=${favoriteFilter}`)
      .map((res: Response) => res.json())
  }

  getFavoritesScreenshots(favoriteFilter){
    this.getData(favoriteFilter).subscribe(data => {
      console.log(data);
      this.data = data;
    })
  }

  getDataByInsertDate(){
    this.getFavoritesScreenshots(FAVORITE_FILTER_INSERT_DATE);    
  }

  getDataRecentlyAdded(){
    this.getFavoritesScreenshots(FAVORITE_FILTER_RECENTLY_ADDED);
  }

  ngOnInit() {}

}
