// import { HttpClient, HttpHeaders } from "@angular/common/http";
// import { Injectable } from "@angular/core";
// import { covid } from "../interfaceCovid";
// import { Observable } from "rxjs";
// import { catchError, tap } from "rxjs/operators";
// import { HttpErrorResponse } from "@angular/common/http";
// import { throwError } from "rxjs";
// import { environment } from "src/environments/environment";
// import { FormControl, FormGroup, Validators } from "@angular/forms";

// @Injectable({
//     providedIn: 'root'
// })

// export class centreService {

//     private readonly _API_URL = environment.host;

//     constructor(private http: HttpClient){}

//     form: FormGroup = new FormGroup({
//       $key: new FormControl(null),
//       nom: new FormControl('', Validators.required),
//       adresse: new FormControl('', Validators.email),
//       postalcode: new FormControl('', [Validators.required, Validators.minLength(5)]),
//       city: new FormControl(''),
//     });
  
//     initializeFormGroup() {
//       this.form.setValue({
//         $key: null,
//         nom: '',
//         adresse: '',
//         city: '',
//       });
//     }
    
//     public getCentres(): Observable<covid[]> {
//         return this.http.get<covid[]>(`${this.CENTRE_API_URL}/centre/list`).pipe(
//           tap(unCentre => console.log('centres: ', unCentre)),
//           catchError(this.handleError)
//       );
//     }

//     public getCentresByName(nom:string): Observable<covid[]> {
//       return this.http.get<covid[]>(`${this.CENTRE_API_URL}/centre/list/nom`).pipe(
//         tap(unCentre => console.log('centres: ', unCentre)),
//         catchError(this.handleError)
//       )
//     }

//     private handleError(error: HttpErrorResponse) {
//         if (error.status === 0) {
//           console.error('An error occurred:', error.error);
//         } else {
//           console.error(
//             `Backend returned code ${error.status}, body was: `, error.error);
//         }
//         return throwError(() => new Error('Something bad happened; please try again later.'));
//       }
// }