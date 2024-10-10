import { Pipe, PipeTransform } from '@angular/core';
import { orderBy } from 'lodash'
// npm install lodash --save   
// npm i --save-dev @types/lodash   --> dowmload these two librabies for loadash

@Pipe({
  name: 'sort'
})
export class SortPipe implements PipeTransform {

  transform(array: any, sortBy: string, order?: string): any[] {
   
     return orderBy(array, [sortBy], ['asc']);
     }
}
