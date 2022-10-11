import { Component, OnInit } from '@angular/core';
import { client } from '../interfaceClient';
import { covid } from '../interfaceCovid';

@Component({
  selector: 'app-pageaccueil',
  templateUrl: './pageaccueil.component.html',
  styleUrls: ['./pageaccueil.component.css']
})
export class PageaccueilComponent implements OnInit {

  city: string= "Dans quelle ville?";
  listeCentres: covid[] = [];

  selected?: covid;

  constructor() { }

  ngOnInit(): void {
  }

  search(): void {
    this.listeCentres = [{
      id: 2,
      name: "CH Narbonne",
      address: "Boulevard Dr Lacroix",
      postalcode: "11100",
      city: "Narbonne"
    },
    {
      id: 3,
      name: "CH Besançon",
      address: "Avenue Carnot",
      postalcode: "54300",
      city: "Besançon"
    },
    {
      id: 4,
      name: "CH Villers-Lès-Nancy",
      address: "Rue Maréchal",
      postalcode: "25480",
      city: "villers-Lès-Nancy"
    },
    {
      id: 5,
      name: "CH Toulouse",
      address: "Rue charles III",
      postalcode: "11085",
      city: "Toulouse"
    }]
    console.log(this.city);
  }

  onChoose(centre:covid){
    this.selected = centre;
  }

  AfficherPlus(): void {
    
  }

  onReserved(patient: client) {
    
  }

}
