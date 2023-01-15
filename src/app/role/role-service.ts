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
                if (bool == true) localStorage.setItem('role', 'ADMINISTRATEUR')
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
            this.httpClient.post<boolean>(environment.host + "/superAdmin/role", roleJson).subscribe(
                data => {

                    console.log("Hello Wold")
                    if (data===true) {
                        localStorage.setItem('role', 'SUPERADMINISTRATEUR');
                        console.log(localStorage.getItem('role'))
                    
                    }
                    console.log(data)

                }
            )    
        }
        else {
            console.log('No user logged in ')
        }

    }


    // pipe(
    //     tap(bool => {
    //         if (bool == true) sessionStorage.setItem('role', 'SUPERADMINISTRATEUR');
    //         console.log('isSuperAdmin: ', bool)
    //     return bool})
    //   )     

    isMedecin = () => {
        if(this.isUserLoggedIn()){
            var form : RoleForm = new RoleForm() ;
            form.mail = sessionStorage.getItem('username')??'';
            const formstr = JSON.stringify(form,null,2);
            const roleJson = JSON.parse(formstr);
            this.httpClient.post(environment.host + "/medecin/role", roleJson).pipe(
                tap(bool => {
                    if (bool == true) localStorage.setItem('role', 'MEDECIN')
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