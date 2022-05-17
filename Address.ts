import { GeoLocation } from "./GeoLocation";
export class Address {
  street! : string;
  suite!: string;
  city!: string;
  zipcode!: string;
  geo!: GeoLocation;
}