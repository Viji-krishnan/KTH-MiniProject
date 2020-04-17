import React from 'react';

function PostCard({ post, onDeleteClick,onUpdateClick}) {
  return (
    <div className='card mt-3'>
      <div className='card-body'>
        <p>{post.body}</p>

        <button className='btn btn-warning' onClick={onUpdateClick} id='update'>
          PUT/PATCH
        </button>
        <button className='btn btn-danger' onClick={onDeleteClick} id='delete'>
          DELETE
        </button>
      </div>
    </div>
  );
}

export default PostCard;
