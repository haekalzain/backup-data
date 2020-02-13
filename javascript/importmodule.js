export class Person{
    constructor(name){
        this.name=name;
    }
    getName(){
        return this.name;
    }
}

export class Employee extends Person{
    doWork(){
        return "completed";
    }
}

