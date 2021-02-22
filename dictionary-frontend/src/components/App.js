import React from 'react'
import { LanguageProvider, Text } from 'containers/Language';
import SearchArea from 'components/search/SearchArea'
import Footer from 'components/Footer'
import NavigationBar from 'components/NavigationBar'

const App = () => {
  
    return (
        <LanguageProvider>
            <NavigationBar className='navigation-bar' />
            <h1><Text textId='dictionary' /></h1>
            <div className='arrow-section'>
                <h3><Text textId='jArrowE' /></h3>
                <h3><Text textId='jArrowJ' /></h3>
            </div>
            <SearchArea />
            <Footer />
        </LanguageProvider>
    );
}

export default App;
