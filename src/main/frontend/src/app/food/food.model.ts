export class Food {
  constructor(
    public id: number,
    public name: string,
    public brand: string,
    public barcode: string,
    public calories: number,
    public protein: number,
    public carbohydrates: number,
    public fat: string,
    public link: string,
    public imageUrl: string,
    public imageSmallUrl: string,
    public imageThumbUrl: string
  ) {}
}
