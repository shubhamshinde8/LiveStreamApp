import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import VideoUpload from './componants/VideoUpload'
import { Toaster } from 'react-hot-toast'

function App() {
  const [count, setCount] = useState(0)

  const [videoId,setVideoId]=useState('f63da140-8447-47e1-853f-25ab2c267107');

  return (
    <>
      <Toaster />
      <div className="flex flex-col items-center space-y-9 justify-center py-9">
        <h1 className="text-3xl font-bold text-gray-800 dark:text-gray-100">
          Video Streaming App
        </h1>
        <div className='flex mt-14 w-full justify-around '>
        <div> 
          <h1 className="text-white">Playing video</h1>
          <video
            style={{ width: 500, height: 500 }}
            src={`http://localhost:8080/api/videos/stream/${videoId}`}
            controls
          ></video>
        </div>

        <VideoUpload />
      </div>
      </div>
    </>
  );
};

export default App;


