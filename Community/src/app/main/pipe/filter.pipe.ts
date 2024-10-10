import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {

  transform(value: any[] , filterString:string, propName1:string,propName2:string,propName3:string): any[] {
    const result:any=[];
    
    if(!value || filterString==='' || propName1==='' || propName2==='' || propName3===''){
      return value;
    }

    value.forEach((a:any)=>{
      if(a[propName1].trim().toLowerCase().includes(filterString.toLowerCase())){
        result.push(a);
      }

      if(a[propName2].trim().toLowerCase().includes(filterString.toLowerCase())){
        result.push(a);
      }

      if(a[propName3].trim().toLowerCase().includes(filterString.toLowerCase())){
        result.push(a);
      }
    })
    return result;
  }

}
