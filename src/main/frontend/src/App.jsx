import logo from './logo.svg';
import axios from 'axios';
import './App.css';
import { useEffect, useState } from 'react';

function App() {
  // const [data, setData] = useState('');
  const [user, setUser] = useState({});
  // useEffect(() => {
  //   axios.get('/rp/react/data')
  //   .then(res => {
  //     console.log(res);
  //     setData(res.data);
  //   })
  //   .catch(err => {console.log(err);});
  // },[]);
  useEffect(() => {
    axios.get(`/rp/react/json`)
    .then(res => {
      setUser(res.data)
      console.log(res);
      console.log('배열정보: ' + res.data);
    })
    .catch(err => console.log(err));
  }, []);
  return (
    // <div className="App">
    //   <header className="App-header">
    //     <img src={logo} className="App-logo" alt="logo" />
    //     <h3>
    //       받아온 값: {data ? data : '받아오지 못했어요'}
    //     </h3>
    //     <h3>
    //       사용자 정보: uid={users.uid}, uname={users.uname}, email={users.email}, github={users.github}, insta={users.insta}
    //     </h3>
    //   </header>
    // </div>
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <h1>사용자 목록</h1>
        <h3>{isLoading ? '로딩중...' : ''}</h3>
        <table border={1}>
          <tr>
            <th>uid</th>
          </tr>
        </table>
      </header>
    </div>
  );
}

export default App;
