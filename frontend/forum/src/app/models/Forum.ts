import { ForumPost } from "./ForumPost";

export class Forum{
    id: number;
    forumName: String;
    description: String;
    creationDate: String;
    forumAdminId : number;
    picture: ByteString;
    forumposts: Array<ForumPost>;
}