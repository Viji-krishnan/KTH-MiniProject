import React from 'react';
import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom';

function PostCard(props) {

  return (
    <div className='card mt-3'>
      <div className='card-body'>
        <Link to={`/posts/${props.post.id}`}>
          <p>{props.post.title}</p>
        </Link>

        <p>{props.post.body}</p>

        <button
          className='btn btn-warning'
          onClick={props.onUpdateClick}
          id='update'>
          Edit
        </button>
        <button
          className='btn btn-danger'
          onClick={props.onDeleteClick}
          id='delete'>
          DELETE
        </button>
      </div>
    </div>
  );
}

export default PostCard;
