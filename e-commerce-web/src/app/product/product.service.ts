// import { Http, Response } from '@angular/http';
// import {Injectable} from '@angular/core';
// import {Observable} from 'rxjs';
// import { map } from 'rxjs/operators';

// @Injectable()
// export class ProductService{
//     url:string = 'http://localhost:8080/productslist';
//     http:Http;

//     constructor(http:Http){
//         this.http = http;
//     }

//     getData(startIndex, pageSize):Observable<Response>{
//         return this.http.get(this.url+ '?page='+startIndex+'&size='+pageSize).pipe(map(this.extractData));
//     }

//     extractData(result: Response){
//         return result.json();
//     }

// }