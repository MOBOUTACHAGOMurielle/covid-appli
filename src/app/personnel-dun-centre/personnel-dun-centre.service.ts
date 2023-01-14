import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { catchError, tap } from "rxjs/operators";
import { HttpErrorResponse } from "@angular/common/http";
import { throwError } from "rxjs";
import { environment } from "src/environments/environment";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import * as _ from 'lodash';
import { client } from "../interfaceClient";
import { covid } from "../interfaceCovid";
import { reservation } from "../interfaceReservations";

@Injectable({
    providedIn: 'root'
})

export class personnelService {

    private readonly PERSONNEL_API_URL = environment.host;

    constructor(private http: HttpClient){}

    formPersonnel: FormGroup = new FormGroup({
      id: new FormControl(null),
      nom: new FormControl(''),
    })

    initializePersonnelFormGroup() {
      this.formPersonnel.setValue({
        id: null,
        nom: '',
      })
    }
    
    public getAdminByCentre(id:number): Observable<client[]> {
        return this.http.get<client[]>(`${this.PERSONNEL_API_URL}/centre/admins/${id}`).pipe(
          tap(unCentre => console.log('admin: ', unCentre)),
          catchError(this.handleError)
      );
    }

    public getMedecinsByCentre(id:number): Observable<client[]> {
      return this.http.get<client[]>(`${this.PERSONNEL_API_URL}/centre/medecins/${id}`).pipe(
        tap(unCentre => console.log('medecin: ', unCentre)),
        catchError(this.handleError)
      )
    }

    public getMedecins(): Observable<client[]> {
      return this.http.get<client[]>(`${this.PERSONNEL_API_URL}/medecin/list`).pipe(
        tap(unMedecin => console.log('medecin: ', unMedecin)),
        catchError(this.handleError)
      )
    }

    public getSuperAdmins(): Observable<client[]> {
      return this.http.get<client[]>(`${this.PERSONNEL_API_URL}/superAdmin/list`).pipe(
        tap(unSuperAdmin => console.log('superAdmin: ', unSuperAdmin)),
        catchError(this.handleError)
      )
    }

    public getReservations(): Observable<reservation[]> {
      return this.http.get<reservation[]>(`${this.PERSONNEL_API_URL}/reservations/list`).pipe(
        tap(uneReservation => console.log('reservation: ', uneReservation)),
        catchError(this.handleError)
      )
    }

    private handleError(error: HttpErrorResponse) {
        if (error.status === 0) {
          console.error('An error occurred:', error.error);
        } else {
          console.error(
            `Backend returned code ${error.status}, body was: `, error.error);
        }
        return throwError(() => new Error('Something bad happened; please try again later.'));
      }
}