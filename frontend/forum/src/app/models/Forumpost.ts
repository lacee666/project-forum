export class ForumPost{
    id: number;
    title: String;
    picture: ByteString;
    description: String;
    user: String;
    comments: Array<Comment>;
    forum: String;
}