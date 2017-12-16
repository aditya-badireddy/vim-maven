import { InMemoryDbService } from 'angular-in-memory-web-api';

export class InMemoryDataService implements InMemoryDbService {
  createDb() {
    const products = [
      {
        "productId": 2,
        "productName": "Garden Cart",
        "productCode": "GDN-0023",
        "releaseDate": "March 18, 2016",
        "description": "15 gallon capacity rolling garden cart",
        "price": 32.99,
        "starRating": 4.2,
        "imageUrl": "https://buythetop10.com/wp-content/uploads/2017/05/Best-Choice-Products-650LB-Garden-Dump-Cart-Wheelbarrow-Wagon-Carrier-Air-Tires-Heavy-Duty--370x371.png"
      },
      {
        "productId": 5,
        "productName": "Hammer",
        "productCode": "TBX-0048",
        "releaseDate": "May 21, 2016",
        "description": "Curved claw steel hammer",
        "price": 8.9,
        "starRating": 4.8,
        "imageUrl": "https://bgsctechclub.files.wordpress.com/2009/10/lever-800px-claw-hammer.jpeg"
      }
    ];
    return { products };
  }
}
