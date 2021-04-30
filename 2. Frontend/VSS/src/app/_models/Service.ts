import { JobCard } from "./JobCard";
import { Feedback } from "./Feedback";
import { Employee } from "./Employee";


export class Service {
    id: number;
    jobcard: JobCard;
    type: string;
    addParts: string;
    employee: Employee;
    feedback: Feedback;
    date: Date;
}
