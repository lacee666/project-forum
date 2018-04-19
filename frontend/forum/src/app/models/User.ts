import {Comment} from './Comment'
import {ForumPost} from './ForumPost'

export class User{
    username: String;
    email: String;
    password: String;
    comments: Array<Comment>;
    upvotes: Array<ForumPost>;
    downvotes: Array<ForumPost>;
    myPosts: Array<ForumPost>;
}