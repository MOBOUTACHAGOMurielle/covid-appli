import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { catchError, map, tap } from "rxjs";
import { environment } from "src/environments/environment";
import { RoleForm } from "./roleForm";



@Injectable({
    providedIn: 'root'
  })
  export class RoleService {
  
    constructor(private httpClient:HttpClient) { }

    isAdmin = () => {
        if(this.isUserLoggedIn()){
        var form : RoleForm = new RoleForm() ;
        form.mail = sessionStorage.getItem('username')??'';
        const formstr = JSON.stringify(form,null,2);
        const roleJson = JSON.parse(formstr);
        this.httpClient.post(environment.host + "/admin/role", roleJson).pipe(
            tap(bool => {
                if (bool == true) sessionStorage.setItem('role', 'ADMINISTRATEUR')
                console.log('isAdmin: ', bool)})
          ) 
        }
        else {
            console.log('No user logged in ')
        }
    }

    isSuperAdmin = () => {
        if(this.isUserLoggedIn()){
            var form : RoleForm = new RoleForm() ;
            form.mail = sessionStorage.getItem('username')??'';
            const formstr = JSON.stringify(form,null,2);
            const roleJson = JSON.parse(formstr);
            this.httpClient.post(environment.host + "/superAdmin/role", roleJson).pipe(
                tap(bool => {
                    if (bool == true) sessionStorage.setItem('role', 'SUPERADMINISTRATEUR')
                    console.log('isSuperAdmin: ', bool)
                return bool})
              )     
        }
        else {
            console.log('No user logged in ')
        }

    }


    isMedecin = () => {
        if(this.isUserLoggedIn()){
            var form : RoleForm = new RoleForm() ;
            form.mail = sessionStorage.getItem('username')??'';
            const formstr = JSON.stringify(form,null,2);
            const roleJson = JSON.parse(formstr);
            this.httpClient.post(environment.host + "/medecin/role", roleJson).pipe(
                tap(bool => {
                    if (bool == true) sessionStorage.setItem('role', 'MEDECIN')
                    console.log('isAdmin: ', bool)
                return bool})
              ) 
        }
        else {
            console.log('No user logged in ')
        }
    }



    isUserLoggedIn() {
      let user = sessionStorage.getItem('username')
      let password = sessionStorage.getItem('password')
      console.log(!(user === null))
      return !(user === null)
    }
}