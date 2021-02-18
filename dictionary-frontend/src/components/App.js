import React from 'react'
import { LanguageProvider, Text } from '../containers/Language';
import SearchArea from './SearchArea'
import Footer from './Footer'

function App() {
  
    return (
        <LanguageProvider>
            <div>
                <h1><Text textId='pageTitle' /></h1>
                <SearchArea />
                <Footer />
            </div>
        </LanguageProvider>
    );
}

export default App;
