import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { covid } from "../interfaceCovid";
import { Observable } from "rxjs";
import { catchError, tap } from "rxjs/operators";
import { HttpErrorResponse } from "@angular/common/http";
import { throwError } from "rxjs";
import { environment } from "src/environments/environment";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { client } from "../interfaceClient";

@Injectable({
    providedIn: 'root'
})

export class infoService {

    private readonly UTILISATEUR_URL = environment.host;

    constructor(private http: HttpClient){}

    UserForm: FormGroup = new FormGroup({
      id: new FormControl(null),
      nom: new FormControl(''),
      prenom: new FormControl(''),
      mail: new FormControl(''),
      password: new FormControl(''),
      role: new FormControl(''),
      centreName: new FormControl('')
    });
  
    initializeUserFormGroup() {
      this.UserForm.setValue({
        id: null,
        nom: '',
        prenom: '',
        mail: '',
        password: '',
        role: '',
        centreName: ''
      });
    }

    public addNewAdmin = (admin: any) => {

      const adminstr = JSON.stringify(admin,null,2);
      const adminJson = JSON.parse(adminstr);
  
      this.http.post(`${this.UTILISATEUR_URL}/admin/save`, adminJson).subscribe({
        error: (err) => {  
          console.error(err) 
        },
  
        complete: () => console.info('save successful')
  
      });
  
    }

    public addNewMedecin = (medecin: any) => {

      const medecinstr = JSON.stringify(medecin,null,2);
      const medecinJson = JSON.parse(medecinstr);
  
      this.http.post(`${this.UTILISATEUR_URL}/medecin/save`, medecinJson).subscribe({
        error: (err) => {  
          console.error(err) 
        },
  
        complete: () => console.info('save successful')
  
      });
  
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