import { Component, OnInit, Input } from '@angular/core';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { ToastyService, ToastyConfig, ToastOptions, ToastData } from 'ng2-toasty';

import { environment } from '../../environments/environment';

@Component({
  selector: 'app-card-deck',
  templateUrl: './card-deck.component.html',
  styleUrls: ['./card-deck.component.css']
})
export class CardDeckComponent implements OnInit {

  constructor(private http: Http, 
              private modalService: NgbModal,
              private toastyService:ToastyService,
              private toastyConfig: ToastyConfig) {
                  
                this.toastyConfig.theme = 'default'; 
  }
  
  @Input("data")
  data: any = {};

  @Input("page")
  page: string;

  favoriteButtonClasses: string;
  favoriteButtonDescription: string;
  screenshot: any;
  
  ngOnInit() {              
    if ( this.page === 'favorite' ) {
        this.favoriteButtonDescription = 'Remover dos favoritos';
        this.favoriteButtonClasses = 'btn btn-danger'
    } else if (this.page === 'navigation' ) {
        this.favoriteButtonClasses = 'btn btn-primary'
        this.favoriteButtonDescription = 'Adicionar aos favoritos';
    }    
  }

  openModal(content, shot) {
    const modalRef = this.modalService.open(content);
    this.screenshot = shot;
  }

  openHidpiImage() {
    window.open(this.screenshot.images.hidpi);    
  }

  favorite() {
    if ( this.page === 'favorite' ) {
      this.removeFromFavorite();
    } else if (this.page === 'navigation' ) {
      this.addToFavorite();
    }
  }

  addToFavorite() {
    let requestOptions = new RequestOptions();
    requestOptions.headers = new Headers({"Content-Type":"application/json"});
    
    return this.http.post(`${environment.apiUrl}/addToFavorites`, this.screenshot, requestOptions).subscribe(
      data => {
        let response = data.json();
        console.log(response)
        if (response.resultStatus === "SUCCESS") {
          this.showSuccess(response.message);
        } else {
          this.showWarn(response.message);          
        }
      },
      err => {    
        this.showError(err['_body']);
      });
  }

  removeFromFavorite() {
    const deleteUrl =`${environment.apiUrl}/removeFromFavorites/${this.screenshot.id}` 
    this.http.delete(deleteUrl).subscribe();

    window.location.reload();
  }

  showSuccess(msg) {
    this.toastyService.success(msg);
  }

  showWarn(msg) {
    this.toastyService.warning(msg);
  }

  showError(msg) {
    this.toastyService.error(msg)
  }
}
