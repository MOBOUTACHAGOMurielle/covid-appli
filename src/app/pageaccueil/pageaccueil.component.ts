import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { client } from '../interfaceClient';
import { covid } from '../interfaceCovid';
import { RoleService } from '../role/role-service';

@Component({
  selector: 'app-pageaccueil',
  templateUrl: './pageaccueil.component.html',
  styleUrls: ['./pageaccueil.component.css']
})
export class PageaccueilComponent implements OnInit {

  city: string= "Dans quelle ville?";
  listeCentres: covid[] = [];

  selected?: covid;

  constructor(public roleService:RoleService, private router:Router) { }

  ngOnInit(): void {
  }

  // search(): void {
  //   this.listeCentres = [{
  //     id: 2,
  //     nom: "CH Narbonne",
  //     adresse: "Boulevard Dr Lacroix",
  //     postalcode: "11100",
  //     city: "Narbonne"
  //   },
  //   {
  //     id: 3,
  //     nom: "CH Besançon",
  //     adresse: "Avenue Carnot",
  //     postalcode: "54300",
  //     city: "Besançon"
  //   },
  //   {
  //     id: 4,
  //     nom: "CH Villers-Lès-Nancy",
  //     adresse: "Rue Maréchal",
  //     postalcode: "25480",
  //     city: "villers-Lès-Nancy"
  //   },
  //   {
  //     id: 5,
  //     nom: "CH Toulouse",
  //     adresse: "Rue charles III",
  //     postalcode: "11085",
  //     city: "Toulouse"
  //   }]
  //   console.log(this.city);
  // }

  onChoose(centre:covid){
    this.selected = centre;
  }

  // onClick(){
  //   this.roleService.isSuperAdmin();
  //   // this.roleService.isAdmin();
  //   this.router.navigateByUrl("/affichage-des-centres")
  // }

  AfficherPlus(): void {
    
  }
}
