import {Comments} from './Comments'
import {Forumpost} from './Forumpost'
export class User{
    username: String;
    email: String;
    password: String;
    comments: Array<Comments>;
    upvotes: Array<Forumpost>;
    downvotes: Array<Forumpost>;
    myPosts: Array<Forumpost>;
}