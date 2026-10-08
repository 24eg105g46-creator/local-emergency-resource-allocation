import {describe,it,expect} from 'vitest';
import {render,screen} from '@testing-library/react';
import {MemoryRouter} from 'react-router-dom';
import App from './App.jsx';
describe('LERCS sign in',()=>{it('shows the accessible sign in form when signed out',()=>{localStorage.clear();render(<MemoryRouter><App/></MemoryRouter>);expect(screen.getByRole('heading',{name:/sign in to lercs/i})).toBeInTheDocument();expect(screen.getByLabelText(/email address/i)).toBeInTheDocument();});});
