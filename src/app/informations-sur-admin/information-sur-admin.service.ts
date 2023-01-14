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

export class infoServiceAdmin {

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

    public adAdminToCentre = (element:any,id:number) =>{
      const adminstr = JSON.stringify(element,null,2);
      const adminJson = JSON.parse(adminstr);
  
      console.log(adminstr);
      this.http.post(`${this.UTILISATEUR_URL}/admin/new/centre/${id}`, adminJson).subscribe({
        error: (err) => {  
          console.error(err) 
        },
  
        complete: () => console.info('admin saved successful')
  
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