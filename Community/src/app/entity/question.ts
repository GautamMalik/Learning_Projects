import { Replies } from "./replies";

export class Question {
    id : number = -1;
    date : string ='';
    author : any;;
    title: string ='';
    body: string='';
    solved:string='';
    replies : Replies[]=[];
}
