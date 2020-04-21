import React from 'react';

function CommentForm(props) {
  const [body, setBody] = React.useState('');

  const handleSubmit = () => {
    // Invoke the passed in event callback
    props.onSubmit({body: body});

    // Clear the input field
    setBody('');
  };

  return (
    <div className='card'>
      <div className='card-body'>
        
        <div>
          <div className='form-group'>
            Comment
            <textarea
              className='form-control'
              value={body}
              onChange={(e) => setBody(e.target.value)}
            />
          </div>

          <div className='form-group'>
            <button className='btn btn-primary' onClick={handleSubmit}>
              Comment
            </button>
          </div>
        </div>
      </div>
    </div>
  );
}

export default CommentForm;
