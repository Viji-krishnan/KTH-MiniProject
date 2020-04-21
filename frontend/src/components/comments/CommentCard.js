import React, { useState } from 'react';

function CommentCard(props) {
  const [body, setBody] = React.useState('');

  const handleSubmit = () => {
    // Invoke the passed in event callback
    console.log(body);
    props.onSubmit({ id:props.comment.id, body: body });

    // Clear the input field
    setBody('');
    window.location.reload();
  };
  const [edit, setEdit] = useState(false);
 
  const editButton = (
    <button
      className='btn btn-warning'
      onClick={() => setEdit(true)}
      id='update'>
      Edit
    </button>
  );
  const deleteButton = (
    <button
      className='btn btn-danger'
      onClick={props.onDeleteClick}
      id='delete'>
      DELETE
    </button>
  );
  const saveButton = (
    <button
      className='btn btn-warning'
      onClick={handleSubmit}
      // onClick={props.onSaveClick}
      id='save'>
      Save
    </button>
  );
  const cancelButton = (
    <button
      className='btn btn-danger'
      onClick={() => setEdit(false)}
      id='cancel'>
      Cancel
    </button>
  );

  const editedText = (
    <textarea
      className='form-control'
      value={body}
      onChange={(e) => setBody(e.target.value)}
    />
  );
  return (
    <div className='card mt-3'>
      <div className='card-body'>
        {edit && editedText}
        <p>{edit || props.comment.body}</p>
        <p> Created at: {props.comment.createdAt}</p>
        {/* <p> {edit && props.comment.updatedAt}</p> */}
        <p>Updated at: {props.comment.updatedAt}</p>
        {edit || editButton}
        {edit || deleteButton}
        {edit && saveButton}

        {edit && cancelButton}
      </div>
    </div>
  );
}

export default CommentCard;
