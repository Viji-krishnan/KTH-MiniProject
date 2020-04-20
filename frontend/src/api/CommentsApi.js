import Api from './Api';

class CommentsApi {
  getAllCommentsByPostId(postId) {
    return Api.get('/posts/' + postId + '/comments');
  }

  getAllComments(postId,commentId){
    return Api.get(`/posts/${postId}/comments/${commentId}`);
  }

  createComment(postId, commentBody) {
    return Api.post(`/posts/${postId}/comments`, commentBody);
  }

  updateComment(postId, commentId, comment) {
    return Api.put('/posts/' + postId + '/comments/' + commentId, comment);
  }

  deleteComment(postId, commentId) {
    return Api.delete('/posts/' + postId + '/comments/' + commentId);
  }
}

export default new CommentsApi();
