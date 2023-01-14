import { covid } from "./interfaceCovid";

export interface reservation {
    id: number;
    creneau:Date;
    status: Boolean;
    centre: covid;
    patient: any;
}