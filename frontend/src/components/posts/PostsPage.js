import React from 'react';
import PostsApi from './../../api/PostsApi';
import PostForm from './PostForm';
import PostCard from './PostCard';
import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom';

class PostsPage extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      posts: [],
      
    };
  }

  changeEditMode=()=>{
    console.log("lets edit")
  }

  async createPost(postData) {
    try {
      const response = await PostsApi.createPost(postData);
      const post = response.data;
      const newPosts = this.state.posts.concat(post);

      this.setState({
        posts: newPosts,
      });
    } catch (e) {
      console.error(e);
    }
  }

  async updatePost(postData) {
    try {
      const response = await PostsApi.updatePost(postData);
      const post = response.data;
      const newPosts = this.state.posts.concat(post);

      this.setState({
        posts: newPosts,
      });
    } catch (e) {
      console.error(e);
    }
  }

  async deletePost(post) {
    try {
      await PostsApi.deletePost(post.id);
      const newPosts = this.state.posts.filter((p) => p.id !== post.id);
      this.setState({
        posts: newPosts,
      });
    } catch (e) {
      console.error(e);
    }
  }

  componentDidMount() {
    PostsApi.getAllPosts()
      .then(({ data }) => this.setState({ posts: data }))
      .catch((err) => console.error(err));
  }

  render() {
    const posts = this.state.posts;

    return (
      <div>
        <PostForm onSubmit={(postData) => this.createPost(postData)} />
        {posts.map((post) => (
          <PostCard
            key={post.id}
            post={post}
            onDeleteClick={() => this.deletePost(post)}
            onUpdateClick={() => this.changeEditMode}
          />
        ))}
        
      </div>
    );
  }
}

export default PostsPage;
